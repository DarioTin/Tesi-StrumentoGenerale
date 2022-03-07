echo "Inizio comandi installazione precondizioni"
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale
curl -sL https://deb.nodesource.com/setup_12.x -o nodesource_setup.sh
cat nodesource_setup.sh
sudo bash nodesource_setup.sh
sudo apt install nodejs
echo "versione di node installata"
node -v
echo "Installazione di npm"
sudo apt install npm
echo "Fine comandi installazione Node"

echo "Inizio comandi esecuzione Frontend"
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/root/frontend
echo "Siamo nella directory FE, proviamo a lanciarlo in esecuzione"
npm install
echo "Installazione npm effettuata, prossimo comando: npm start"
npm start &
