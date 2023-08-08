import { ContactData, SignUpForm } from './signup-form.interface';

// export interface LoginForm extends Pick<SignUpForm, 'email' | 'password'> {}
export interface LoginForm
  extends Pick<ContactData, 'email'>,
    Pick<SignUpForm, 'password'> {}
