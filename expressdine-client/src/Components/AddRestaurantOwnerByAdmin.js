import React, { useEffect } from "react";
import { useState } from "react";
import UserService from "../Services/UserService";
import "../css/viewRestAdmin.css";
import { useForm } from "react-hook-form";
import swal from "sweetalert";

const AddRestaurantOwnerByAdmin = () => {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userId] = useState(sessionStorage.getItem("userId"));


  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  },[])

  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
    trigger,
  } = useForm();

  const onSubmit = (data) => {
    let ownerData = {
      user: {
        name: data.name,
        address: data.address,
        phone: data.phone,
        role: "rest_owner",
      },
      login: {
        email: data.email,
        password: data.password,
      },
    };

    UserService.addUser(ownerData)
      .then((res) => {
        swal({
          title: "Restaurant owner added",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
        setTimeout(() => ( window.location = "/adminDashboard"), 2000);
      })
      .catch((error) => {
        console.log(error);
      });
    reset();
  };

  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="formba">
          <h1>Add Restaurant Owner</h1>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={handleSubmit(onSubmit)}>
            <div className="inputstyle">
              <input
                type="text"
                className={`form-control ${errors.name && "invalid"}`}
                {...register("name", { required: "Name is Required" })}
                onKeyUp={() => {
                  trigger("name");
                }}
                id="name"
                value={name}
                placeholder="Enter Name.."
                onChange={(e) => setName(e.target.value)}
              />
              {errors.name && (
                <small className="text-danger">{errors.name.message}</small>
              )}
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className={`form-control ${errors.address && "invalid"}`}
                {...register("address", { required: "Address is Required" })}
                onKeyUp={() => {
                  trigger("address");
                }}
                id="address"
                value={address}
                placeholder="Enter Your Address.."
                onChange={(e) => setAddress(e.target.value)}
              />
              {errors.address && (
                <small className="text-danger">{errors.address.message}</small>
              )}
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className={`form-control ${errors.phone && "invalid"}`}
                {...register("phone", {
                  required: "Phone is Required",
                  pattern: {
                    value:
                      /^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$/,
                    message: "Invalid phone no",
                  },
                })}
                onKeyUp={() => {
                  trigger("phone");
                }}
                id="phone"
                value={phone}
                placeholder="Enter Phone Number.."
                onChange={(e) => setPhone(e.target.value)}
              />
              {errors.phone && (
                <small className="text-danger">{errors.phone.message}</small>
              )}
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className={`form-control ${errors.email && "invalid"}`}
                {...register("email", {
                  required: "Email is Required",
                  pattern: {
                    value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                    message: "Invalid email address",
                  },
                })}
                onKeyUp={() => {
                  trigger("email");
                }}
                id="email"
                value={email}
                placeholder="Enter Email.."
                onChange={(e) => setEmail(e.target.value)}
              />
              {errors.email && (
                <small className="text-danger">{errors.email.message}</small>
              )}
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className={`form-control ${errors.password && "invalid"}`}
                {...register("password", { required: "Password is Required" })}
                onKeyUp={() => {
                  trigger("password");
                }}
                id="password"
                value={password}
                placeholder="Enter Password.."
                onChange={(e) => setPassword(e.target.value)}
              />
              {errors.password && (
                <small className="text-danger">{errors.password.message}</small>
              )}
            </div>

            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};
export default AddRestaurantOwnerByAdmin;
