export class User {
  constructor(public email: string, private token:string) {
  }


  getEmail(): string {
    return this.email;
  }

  getToken(): string {
    return this.token;
  }

}
