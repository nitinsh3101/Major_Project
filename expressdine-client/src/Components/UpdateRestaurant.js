import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import RestaurantService from "../Services/RestaurantService";
import swal from "sweetalert";

const UpdateRestaurant = () => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [phone, setPhone] = useState("");
  const [offerPercent, setOfferPercent] = useState("");
  const { restId } = useParams();
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    RestaurantService.getRestaurantById(restId).then((res) => {
      setId(res.data?.id);
      setName(res.data?.name);
      setAddress(res.data?.address);
      setPhone(res.data?.phone);
      setOfferPercent(res.data?.offerPercent);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    let restaurant = {
      id: id,
      name: name,
      address: address,
      phone: phone,
      offerPercent: offerPercent,
    };

    RestaurantService.updateRestaurant(restaurant, restaurant.id)
      .then((res) => {
        swal({
          title: "Restaurant edited",
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
      <div class="formback">
      <h1>Edit Restaurant </h1>
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

export default UpdateRestaurant;
