import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../services/payment.service';
import { MerchantDTO } from '../model/MerchantDTO';
import { MethodOfPaymentDTO } from '../model/MethodOfPaymentDTO';
import { UserBitcoinDTO } from '../model/userDTOS/UserBitcoinDTO';
import { UserPayPalDTO } from '../model/userDTOS/UserPayPalDTO';

@Component({
  selector: 'app-register-merchant',
  templateUrl: './register-merchant.component.html',
  styleUrls: ['./register-merchant.component.css']
})
export class RegisterMerchantComponent implements OnInit {

  private allPaymentMethods = [];
  private method = false;
  private choosenMethods = [];
  private merchantInfo = new MerchantDTO();
  private paymentFields = [];

  constructor(private paymentService : PaymentService) { }

  ngOnInit() {

    this.paymentService.getPaymentMethods().subscribe(res => {

      this.allPaymentMethods = res;

    }, err => {
     // alert("Error");
    });

  }

  getPaymentForms(){

    this.merchantInfo.supportedMethods = new Array<MethodOfPaymentDTO>();
    
    this.choosenMethods.forEach(element => {

      this.allPaymentMethods.forEach(element2 =>{

        if(element == element2.name)
        {
          this.merchantInfo.supportedMethods.push(element2);
        }
      });
    });
  }
  
  onSubmit(){
    
    this.paymentService.registerMerchant(this.merchantInfo).subscribe(res => {
      alert("Uspeh");

      this.registerInPaymentService();

    }, err =>{
      alert(err);
    });
  }
  //nije bas pametno resenje ali je najbrze, sta cu
  registerInPaymentService(){

    this.merchantInfo.supportedMethods.forEach(element => {

      //dopuniti podatke za bitcoin!
      if(element.name == 'Bitcoin')
      {
        let token = "";

        element.fields.forEach(elementb =>{
          token = elementb.value;
        });

        this.paymentService.addUserInPaymentService(element.path, new UserBitcoinDTO(element.path,token)).subscribe(
          res =>{
            
          }, err => {
            alert("Error while adding user to bitcoin service");
          })

      }else if(element.name == 'PayPal')
      {
        let clientId = "";
        let clientSecret = "";

        element.fields.forEach(elementP =>{
          if(elementP.name == 'Client id')
          {
            clientId = elementP.value;
          }else if(elementP.name == 'Client password')
          {
            clientSecret = elementP.value;
          }
        });
        
        this.paymentService.addUserInPaymentService(element.path, new UserPayPalDTO(this.merchantInfo.username,clientId,clientSecret))
        .subscribe(res => {
          alert("Merchant " + this.merchantInfo.merchantName + " registrated!");
          window.location.href = "https://localhost:1234";
        },err => {
          alert("Error while adding user to paypal service");
        });
      }else if(element.name == 'Bank')
      {
        //dodati za bankuuu
      }

    });
  }


}
