import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {

  phone: number;
  otp: number;
  newotp:number;
  validotp: boolean = true;
  constructor(private router: Router) {}
 
  ngOnInit(): void {}

  getOTP(){
    this.newotp=Math.floor(Math.random()*10000);
    alert("Your OTP is "+this.newotp);
  }
  onSubmit() {
    if (this.otp !==this.newotp) {
      this.validotp = false;
    } else {
      this.router.navigate(['/changepassLink']);
    }
  }


}
