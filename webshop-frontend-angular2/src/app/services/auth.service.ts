import { LoginForm } from 'src/app/models/login-form.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from 'src/environment/environment';
import { SignUpForm } from '../models/signup-form.interface';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private url = environment.baseUrl + '/auth';

  constructor(private httpClient: HttpClient) {}

  login(loginFormData: LoginForm) {
    const response = this.httpClient.post(`${this.url}/login`, loginFormData);
    return response;
  }

  signUp(signUpFormData: SignUpForm) {
    const response = this.httpClient.post(`${this.url}/signup`, signUpFormData);
    return response;
  }

  logout() {}
}
