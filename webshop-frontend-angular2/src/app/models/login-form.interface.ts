import { SignUpForm } from './signup-form.interface';

export interface LoginForm extends Pick<SignUpForm, 'email' | 'password'> {}
