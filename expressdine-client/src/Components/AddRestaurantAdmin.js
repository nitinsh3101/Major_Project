import React, { useEffect } from "react";
import { useState } from "react";
import RestaurantService from "../Services/RestaurantService";
import "../css/viewRestAdmin.css";
import swal from "sweetalert";

const AddRestaurantAdmin = () => {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [ownerId, setOwnerId] = useState("");
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    let restaurant = {
      name: name,
      address: address,
      phone: phone,
      offerPercent: 0,
      user: {
        id: ownerId,
      },
    };

    RestaurantService.addRestaurant(restaurant)
      .then((res) => {
        swal({
          title: "Restaurant added",
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
  };

  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="formbackg">
          <h1>Add Restaurant</h1>
          <hr width="100%" size="10" color="black" align="center"></hr>
          <form onSubmit={handleSubmit}>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="name"
                value={name}
                placeholder="Enter Name.."
                onChange={(e) => setName(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="address"
                value={address}
                placeholder="Enter Address.."
                onChange={(e) => setAddress(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="phone"
                value={phone}
                placeholder="Enter Phone Number.."
                onChange={(e) => setPhone(e.target.value)}
              />
            </div>
            <div className="inputstyle">
              <input
                type="text"
                className="form-control"
                id="ownerId"
                value={ownerId}
                placeholder="Enter Owner Id.."
                onChange={(e) => setOwnerId(e.target.value)}
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

export default AddRestaurantAdmin;
