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

    // validate if passwords match

    const signUpFormData: SignUpForm = {
      personalCode: formValue.personalCode, //
      firstName: formValue.firstName, //
      lastName: formValue.lastName, //
      password: formValue.password, //
      contactData: {
        email: formValue.email, //
        phone: formValue.phone, //
        address: {
          country: formValue.country,
          county: formValue.county,
          street: formValue.street,
          number: formValue.number,
          postalIndex: formValue.postalIndex,
        },
      },
    };

    this.authService.signUp(signUpFormData).subscribe();
  }
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
