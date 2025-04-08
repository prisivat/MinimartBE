package com.example.EShop.Service;


import com.example.EShop.Model.User;
import com.example.EShop.Exception.*;
import com.example.EShop.Model.*;

public class EmailTemplate {

    public static String getForgotPassTemplate(String accessToken){
        return "<html>" +
                "     <head>             <meta charset='UTF-8'>      " +
                "                            <meta name='viewport' content='width=device-width, initial-scale=1.0'>     " +
                "                                               <style>                     " +
                "                     body {                             font - family: Arial, sans-serif;                     " +
                "                     background-color: #f4f4f4;                         margin: 0;                         padding: 20px;    " +
                "                 " +
                "                      }                         .container {                             background - color: #ffffff;      " +
                "                                    padding: 20px;                         margin: auto;                       " +
                "                   max-width: 600px;                         border-radius: 8px;                       " +
                "                   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);         }                         h2 {                             color: #333333;         }                         p {                             line - height: 1.6;                         color: #555555;         }                         .appointment-details {                             margin: 20px 0;         }                         .appointment-details p {                             margin: 5px 0;         }     " +
                "                                     .footer {                             margin - top: 30px;                         font-size: 12px;          " +
                "                                color: #888888;         }                     </style>                 </head> " +
                "<body style='margin: 0; padding: 0; font-family: Arial, sans-serif; '>   " +
                "                 <div style='position: relative; padding: 20px;'>   " +
                "                     " +
                "                 <div style='margin-top: 10px; color:black !important'>  " +
                "                                 Hello,<br/><br/>  " +
                "                                 We’ve received a request to reset your Minimart password.<br/><br/></div>  " +
                "                               <div> <span style = 'color: black'> Access Token: <b>"+accessToken+"</b></span></br></br></br></div> " +
                "                                 <div style = 'color: black'> 'Note: Token valid for 10 minutes. ' <br/><br/>Your password should have 8 or more characters with at least one uppercase letter, lowercase letter, number and special character. <br/><br/>  " +
                "                                 If you have any queries, please contact the help desk. </div>  <br/><br/>  " +
                "                                <div style = 'color : black'> Kind regards,</br></br></div>  " +
                "                                 <div style = 'color : black'>Minimart</br></br></br></div>  " +
                "                                 </div></br><div> " +
                "                                 </div></div></body></html>";
    }

    public static String getForgotUserNameTemplate(User user){
        return "<html>" +
                "     <head>             <meta charset='UTF-8'>      " +
                "                            <meta name='viewport' content='width=device-width, initial-scale=1.0'>     " +
                "                                                  <style>                     " +
                "                     body {                             font - family: Arial, sans-serif;                     " +
                "                     background-color: #f4f4f4;                         margin: 0;                         padding: 20px;    " +
                "                 " +
                "                      }                         .container {                             background - color: #ffffff;      " +
                "                                    padding: 20px;                         margin: auto;                       " +
                "                   max-width: 600px;                         border-radius: 8px;                       " +
                "                   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);         }                         h2 {                             color: #333333;         }                         p {                             line - height: 1.6;                         color: #555555;         }                         .appointment-details {                             margin: 20px 0;         }                         .appointment-details p {                             margin: 5px 0;         }     " +
                "                                     .footer {                             margin - top: 30px;                         font-size: 12px;          " +
                "                                color: #888888;         }                     </style>                 </head> <body style='margin: 0; padding: 0; font-family: Arial, sans-serif; '>           " +
                "        <div style='position: relative; padding: 20px;'>       " +
                "<div style='margin-top: 10px; color:black !important'>             " +
                "      Hello <b>"+user.getFirstName()+"</b>,<br/><br/>                " +
                "   Please use this User Name:<b>"+ user.getUserName() +"</b> and try to login Minimart with your credentials.<br/><br/></div>     " +
                "   <div style = 'color: black'>              " +
                "     If you have any queries, please contact the help desk. </div> " +
                " <br/><br/>  <div style = 'color : black'> Kind regards,</br></br ></div >       " +
                "" +
                "<div style='color : black'>Minimart</br></br ></br ></div >  </div ></br > " +
                "" +
                "<div>" +
                "  </div></div ></body ></html >";
    }

    public static String getRegistrationSuccessTemplate(User user){
        return "<html>" +
                "     <head>             <meta charset='UTF-8'>      " +
                "                            <meta name='viewport' content='width=device-width, initial-scale=1.0'>     " +
                "                                                   <style>                     " +
                "                     body {                             font - family: Arial, sans-serif;                     " +
                "                     background-color: #f4f4f4;                         margin: 0;                         padding: 20px;    " +
                "                 " +
                "                      }                         .container {                             background - color: #ffffff;      " +
                "                                    padding: 20px;                         margin: auto;                       " +
                "                   max-width: 600px;                         border-radius: 8px;                       " +
                "                   box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);         }                         h2 {                             color: #333333;         }                         p {                             line - height: 1.6;                         color: #555555;         }                         .appointment-details {                             margin: 20px 0;         }                         .appointment-details p {                             margin: 5px 0;         }     " +
                "                                     .footer {                             margin - top: 30px;                         font-size: 12px;          " +
                "                                color: #888888;         }                     </style>                 </head> " +
                "<body style='margin: 0; padding: 0; font-family: Arial, sans-serif; '>           " +
                "        <div style='position: relative; padding: 20px;'>       " +
                "<div style='margin-top: 10px; color:black !important'>             " +
                "      Dear <b>"+user.getFirstName()+"</b>,<br/><br/>                " +
                "   Registration Success!<br/><br/></div>     " +
                "   <div style = 'color: black'>              " +
                "     Thanks for Using Minimart, If you have any queries, please contact the help desk. </div> " +
                " <br/><br/>  <div style = 'color : black'> Kind regards,</br></br ></div >       " +
                
                "<div style='color : black'>Minimart</br></br ></br ></div >  </div ></br > " +
                
                "<div>" +
                "  </div></div ></body ></html >";
    }


    public static String getLoginSuccess(User user, String otp) {

        return "<html><body style='margin: 0; padding: 0; font-family: Arial, sans-serif; '>   " +
                "                 <div style='position: relative; padding: 20px;'>   " +
                "                     " +
                "                 <div style='margin-top: 10px; color:black !important'>  " +
                "                                 Hello "+user.getFirstName()+",<br/><br/>  " +
                "                                 <br/><br/></div>  " +
                "                               <div> <span style = 'color: black'> Use this OTP : <b>"+otp+" </b> to login </span></br></br></br></div> " +
                "                                 <div style = 'color: black'> 'Note: OTP valid for 2 minutes. ' <br/><br/> <br/><br/>  " +
                "                                 If you have any queries, please contact the help desk. </div>  <br/><br/>  " +
                "                                <div style = 'color : black'> Kind regards,</br></br></div>  " +
                "                                 <div style = 'color : black'>Minimart</br></br></br></div>  " +
                "                                 </div></br><div> " +
                "                                 </div></div></body></html>";
    }

}
