export interface SignUpForm {
  personalCode: string;
  firstName: string;
  lastName: string;
  password: string;
  contactData: ContactData;
}

export interface ContactData {
  email: string;
  phone: string;
  address: Address;
}

export interface Address {
  country: string;
  county: string;
  street: string;
  number: string;
  postalIndex: string;
}

/* {
  "personalCode": "1",
  "firstName": "John",
  "lastName": "Doe",
  "password": "password",
  "contactData": {
      "email": "john.doe12@example.com",
      "phone": "+372555555",
      "address": {
          "country": "Estonia",
          "county": "Harju",
          "street": "123 Main Street",
          "number": "12",
          "postalIndex": "12345"
      }
  }
} */
