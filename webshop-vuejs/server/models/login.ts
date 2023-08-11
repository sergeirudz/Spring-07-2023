import { ContactData, Register } from "./register";

export interface Login extends Pick<Register, "password">, Pick<ContactData, "email"> {}
