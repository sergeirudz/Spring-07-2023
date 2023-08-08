import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginForm } from 'src/app/models/login-form.interface';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  handleSubmit(loginForm: NgForm) {
    const formValue = loginForm.value;

    const loginFormData: LoginForm = {
      email: formValue.email,
      password: formValue.password,
    };

    console.log(loginFormData);
  }
}
