export interface Register {
    personalCode: string;
    firstName: string;
    lastName: string;
    password: string;
    passwordConfirm: string;
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
