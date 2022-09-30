import React, { useEffect, useState } from "react";
import axios from "axios";
import "../css/viewRestAdmin.css";
import Zoom from "react-reveal/Zoom";
import DeleteIcon from "@mui/icons-material/Delete";
import Button from "@mui/material/Button";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import RestaurantService from "../Services/RestaurantService";
import swal from "sweetalert";

const ViewRestaurantAdmin = () => {
  const [userId] = useState(sessionStorage.getItem("userId"));
  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    RestaurantService.allRestaurant().then((res) => {
      setRestaurants(res.data);
    });
  }, []);

  const updateRestaurant = (restaurant) => {
    window.location = `/editRestaurant/${restaurant.id}`;
  };

  const deleteRestaurant = (id) => {
    RestaurantService.deleteRestaurant(id).then((response) => {
      swal({
        title: "Restaurant deleted",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => ( window.location = "/viewRestAdmin"), 2000);
    });
  };

  return (
    <div className="loginbackground">
      <div className="layout">
        {restaurants.map((restaurant) => (
          <Zoom bottom>
            <div className="card" style={{ width: 270, padding: 15 }}>
              <img
                src="https://png.pngtree.com/png-vector/20190223/ourmid/pngtree-restaurant-vector-icon-png-image_711542.jpg"
                className="card-img-top"
                alt="..."
              ></img>

              <div className="card-body">
                <h2 className="card-title">{restaurant.name}</h2>
                <p>Location: {restaurant.address}</p><hr></hr>
                <p>Phone: {restaurant.phone}</p><hr></hr>
                <p> Offer: {restaurant.offerPercent} %</p><hr></hr>
                <Button
                  variant="outlined"
                  onClick={() => deleteRestaurant(restaurant.id)}
                  color="error"
                  startIcon={<DeleteIcon />}
                >
                  Delete
                </Button>
                <Button
                  variant="contained"
                  onClick={() => updateRestaurant(restaurant)}
                  endIcon={<ModeEditIcon />}
                >
                  Update
                </Button>
              </div>
            </div>
          </Zoom>
        ))}
      </div>
    </div>
  );
}

export default ViewRestaurantAdmin;
