import React from "react";
import { useState } from "react";
import LoginService from "../Services/LoginService";
import "../css/homepage.css";
import swal from "sweetalert";
import Zoom from "react-reveal/Zoom";

const Login = () => {
  const [email, setEmail] = useState("");
  const [otpInput, setOtpInput] = useState("");
  const [otp, setOtp] = useState("");
  const [role, setRole] = useState("");

  const sendOtp = (e) => {
    e.preventDefault();

    let user = {
      email: email,
    };

    LoginService.login(user)
      .then((res) => {
        if (res.data[1]?.attempts >= 3) {
          swal({
            title: "Oops",
            text: "Your account has been locked due to Multiple login attempts !",
            icon: "error",
            timer: 2800,
            showCancelButton: false,
            showConfirmButton: false,
            buttons: false,
          });

          setTimeout(() => (window.location = "/"), 3000);
        }

        sessionStorage.setItem("loginId", res.data[1]?.email);
        sessionStorage.setItem("userId", res.data[0]?.id);
        sessionStorage.setItem("role", res.data[0]?.role);
        setOtp(res.data[2]);
        setRole(res.data[0]?.role);
      })
      .catch((error) => {
        swal({
          title: "Oops",
          text: "Email entered is uncorrect !",
          icon: "error",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
      });
  };

  const verifyOtp = (e) => {
    e.preventDefault();
    var loginId = sessionStorage.getItem("loginId");
    if (otpInput === otp && otp !== "") {
      swal({
        title: "Login Successful",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });

      setTimeout(() => {
      LoginService.countLoginAttempt(loginId, "false");

      switch (role) {
        case "user":
          window.location = "/restaurant";
          break;
        case "admin":
          window.location = "/adminDashboard";
          break;
        case "rest_owner":
          window.location = "/restOwnerDashboard";
          break;
        default:
          window.location = "/login";

        }
      }, 2000);
    } else {
      LoginService.countLoginAttempt(loginId, "true");
      sessionStorage.clear();
      window.location = "/login";
    }
  };

  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="form">
          <Zoom top>
            {" "}
            <h1>Login</h1>
          </Zoom>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={sendOtp}>
            <div className="inputstyle">
              <label htmlFor="otp" className="form-label">
                Enter Your Email :
              </label>
              <input
                type="email"
                className="form-control"
                id="email"
                value={email}
                placeholder="Enter Your Email.."
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>

            <button type="submit" className="btn btn-primary">
              Generate OTP
            </button>
          </form>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={verifyOtp}>
            <div className="inputstyle">
              <label htmlFor="otp" className="form-label">
                Enter Otp here :
              </label>
              <input
                type="text"
                className="form-control"
                id="otpInput"
                placeholder="Enter Your Otp.."
                onChange={(e) => setOtpInput(e.target.value)}
              />
            </div>
            <button type="submit" className="btn btn-primary">
              Verify otp
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
