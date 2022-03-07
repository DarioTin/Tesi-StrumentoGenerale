package com.dariotintore.backend.Service;

import com.dariotintore.backend.Entity.Book;
import com.dariotintore.backend.Entity.Order;
import com.dariotintore.backend.Repository.OrderRepository;
import com.dariotintore.backend.Utils.ResponseHelper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private TokenService tokenService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return order;
    }

    public ResponseEntity<JSONObject> makeOrder(JSONObject body) {
        String email = (String) body.get("email");
        String token = (String) body.get("token");
        String isbn = (String) body.get("isbn");
        String quantityString = body.get("quantity").toString();
        int quantity = Integer.parseInt(quantityString);
        if (tokenService.validateToken(email, token).getStatusCode().value() == 403) {
            return ResponseHelper.buildForbiddenResponse("Token not valid");
        }
        if (bookService.checkBookAvailability(isbn, quantity).getStatusCode().value() == 400) {
            return ResponseHelper.buildBadRequestResponse("Books not available");
        }
        Order order = new Order(isbn, quantity, email, new Date(System.currentTimeMillis()), false);
        orderRepository.save(order);
        subtractQuantity(isbn, quantity);
        return ResponseHelper.buildOkResponse("Order correctly made");
    }

    private boolean subtractQuantity(String isbn, int quantity) {
        bookService.subtractQuantity(isbn, quantity);
        return true;
    }

    public ResponseEntity<JSONObject> getOrderPerEmail(JSONObject body) {
        String email = (String) body.get("email");
        List<Order> orders = orderRepository.findByEmail(email);
        List<JSONObject> array = new ArrayList<>();
        for (Order order : orders) {
            System.out.println(order.getIsbn());
            Book book = bookService.findBookByIsbn(order.getIsbn());
            JSONObject bookData = new JSONObject();
            bookData.put("id", order.getId());
            bookData.put("title", book.getTitle());
            bookData.put("isbn", book.getIsbn());
            bookData.put("author", book.getAuthor());
            bookData.put("publisher", book.getPublisher());
            bookData.put("img", book.getImg());
            bookData.put("date", order.getDate());
            bookData.put("quantity", order.getQuantity());
            bookData.put("shipped", order.isShipped());
            array.add(bookData);
        }
        JSONObject response = new JSONObject();
        response.put("books", array);
        return ResponseHelper.buildOkResponse(response, "Books retrieved!");
    }

    public ResponseEntity<JSONObject> deleteOrderById(Long id) {
        this.orderRepository.deleteById(id);
        return ResponseHelper.buildOkResponse("Order deleted!");
    }
}

