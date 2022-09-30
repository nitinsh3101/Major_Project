import React from "react";
import { useState, useEffect } from "react";
import UserService from "../Services/UserService";
import "../css/updateUser.css";
import swal from "sweetalert";

const UpdateUser = () => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    UserService.getUserById(userId).then((res) => {
      setId(res.data?.id);
      setName(res.data?.name);
      setAddress(res.data?.address);
      setPhone(res.data?.phone);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    let user = {
      id: id,
      name: name,
      address: address,
      phone: phone,
    };

    UserService.UpdateUser(user, user.id)
      .then((res) => {
        swal({
          title: "Info Edited",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
        setTimeout(() => ( window.location = "/restaurant"), 2000);
        window.location = "/restaurant";
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="formback">
          <h1>Edit Profile</h1>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label for="exampleInputEmail1" className="form-label">
                Name
              </label>
              <input
                type="text"
                className="form-control"
                id="name"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label for="exampleInputPassword1" className="form-label">
                Address
              </label>
              <input
                type="text"
                className="form-control"
                id="address"
                value={address}
                onChange={(e) => setAddress(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label for="exampleInputPassword1" className="form-label">
                Phone
              </label>
              <input
                type="text"
                className="form-control"
                id="phone"
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
              />
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

export default UpdateUser;
