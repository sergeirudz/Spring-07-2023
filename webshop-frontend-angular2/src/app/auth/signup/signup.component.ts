import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SignUpForm } from 'src/app/models/signup-form.interface';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
})
export class SignupComponent {
  constructor(private authService: AuthService) {}

  handleSubmit(signUpForm: NgForm) {
    const formValue = signUpForm.value;

    const signUpFormData: SignUpForm = {
      firstName: formValue.firstName,
      lastName: formValue.lastName,
      personalCode: formValue.personalCode,
      phone: formValue.phone,
      email: formValue.email,
      address: formValue.address,
      password: formValue.password,
      confirmPassword: formValue.confirmPassword,
    };

    this.authService.signUp(signUpFormData).subscribe();
  }
}
