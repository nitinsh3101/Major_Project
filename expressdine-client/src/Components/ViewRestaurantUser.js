import React, { useEffect, useState } from "react";
import RestaurantService from "../Services/RestaurantService";
import "../css/allcards.css";
import Zoom from "react-reveal/Zoom";
import RestaurantMenuIcon from "@mui/icons-material/RestaurantMenu";
import Button from "@mui/material/Button";
import FavoriteIcon from "@mui/icons-material/Favorite";
import Stack from "@mui/material/Stack";
import swal from "sweetalert";

const ViewRestaurantUser = () => {
  const [restaurants, setRestaurants] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    RestaurantService.allRestaurant().then((res) => {
      console.log(res.data);
      setRestaurants(res.data);
      setFilteredData(res.data);
    });
  }, []);

  const handleFilter = (event) => {
    const searchWord = event.target.value;
    const newFilter = restaurants.filter((value) => {
      return value.name.toLowerCase().includes(searchWord.toLowerCase());
    });

    setFilteredData(newFilter);
  };

  const viewMenu = (restaurant) => {
    window.location = `/viewFoodUser/${restaurant.id}/${restaurant.name}`;
  };
  const addRestToFav = (restId) => {
    let FavouriteRestaurant = {
      restaurant: {
        id: restId,
      },
      user: {
        id: userId,
      },
    };

    RestaurantService.addToFavRestaurant(FavouriteRestaurant).then((res) => {
      swal({
        title: "Added to favourite",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
    });
  };

  return (
    <div className="loginbackground">
      <div className="search">
        <div className="searchInput">
          <input
            id="input"
            type="text"
            placeholder="Search Restaurants..."
            onChange={handleFilter}
          />
        </div>
        <div className="dataResult">
          {filteredData.map((restaurant) => (
            <Zoom bottom>
              <div className="cards" style={{ width: 270, padding: 15 }}>
                <img
                  src="https://png.pngtree.com/png-vector/20190223/ourmid/pngtree-restaurant-vector-icon-png-image_711542.jpg"
                  class="card-img-top"
                  alt="..."
                ></img>

                <div className="card-body">
                  <h2 className="card-title">{restaurant.name}</h2>
                  <p>Location: {restaurant.address}</p>
                  <hr></hr>
                  <p>Phone: {restaurant.phone}</p>
                  <hr></hr>
                  <p> Offer: {restaurant.offerPercent} %</p>
                  <hr></hr>
                  <Stack direction="row" spacing={2} justifyContent={"center"}>
                    <Button
                      variant="outlined"
                      onClick={() => viewMenu(restaurant)}
                      startIcon={<RestaurantMenuIcon />}
                    ></Button>
                    <Button
                      variant="outlined"
                      onClick={() => addRestToFav(restaurant.id)}
                      color="error"
                      startIcon={<FavoriteIcon />}
                    ></Button>
                  </Stack>
                </div>
              </div>
            </Zoom>
          ))}
        </div>
      </div>
    </div>
  );
};

export default ViewRestaurantUser;
