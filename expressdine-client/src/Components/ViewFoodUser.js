import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import CartService from "../Services/CartService";
import FoodService from "../Services/FoodService";
import { ReactToPrint } from "react-to-print";
import { Table } from "react-bootstrap";
import "../css/allcards.css";
import Flip from "react-reveal/Flip";
import "../css/viewFoodUser.css";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import Button from "@mui/material/Button";
import FavoriteIcon from "@mui/icons-material/Favorite";
import Stack from "@mui/material/Stack";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import swal from "sweetalert";


const ViewFoodUser = () => {
  const { restId, restName } = useParams();
  const [foodList, setFoodList] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [userId] = useState(sessionStorage.getItem("userId"));

  const handleFilter = (event) => {
    const searchWord = event.target.value;
    const newFilter = foodList.filter((value) => {
      return value.name.toLowerCase().includes(searchWord.toLowerCase());
    });

    setFilteredData(newFilter);
  };

  const addCart = (food) => {
    let cart = {
      quantity: 1,
      amount: food.price,
      food: {
        id: food.id,
      },
      user: {
        id: userId,
      },
    };


    swal({
      title: 'Food added to cart',
      text: 'Go to cart to place your order.',
      icon: "success",
      timer: 2000,
      showCancelButton: false,
      showConfirmButton: false,
      buttons: false
    })


    CartService.addToCart(cart).then((res) => {
      console.log(res);
    });
  };

  const addToFav = (foodId) => {
    let FavouriteFood = {
      food: {
        id: foodId,
      },
      user: {
        id: userId,
      },
    };

    FoodService.addToFavFood(FavouriteFood).then((res) => {
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

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    FoodService.getAllFood(restId)
      .then((response) => {
        setFoodList(response.data);
        setFilteredData(response.data);
      })
      .catch((error) => {
        this.setState({ errorMessage: error.message });
        console.error("There was an error!", error);
      });
  }, []);

  return (
    <div class="loginbackground">
      <div>
        <h3>{restName}'s Menu</h3>
        <div className="search">
          <div className="searchInput">
            <input
              type="text"
              placeholder="Search food..."
              onChange={handleFilter}
            />
          </div>
          <div className="dataResult">
            {filteredData.map((food) => (
              <Flip right>
                <div class="card" style={{ width: 250, padding: 15 }}>
                  <img
                    src="https://png.pngtree.com/png-vector/20190507/ourmid/pngtree-vector-food-icon-png-image_1024923.jpg"
                    class="card-img-top"
                    alt="..."
                  ></img>

                  <div class="card-body">
                    <h2 class="card-title">{food.name}</h2>
                    <p> Price: {food.price}</p>
                    <hr></hr>
                    <p> Category: {food.category}</p>
                    <hr></hr>
                    <p> Deliver In: {food.deliveryTime} Hr</p>
                    <hr></hr>
                    <Stack
                      direction="row"
                      spacing={2}
                      justifyContent={"center"}
                    >
                      <Button
                        variant="outlined"
                        onClick={() => addCart(food)}
                        startIcon={<AddShoppingCartIcon />}
                      ></Button>
                      <Button
                        variant="outlined"
                        onClick={() => addToFav(food.id)}
                        color="error"
                        startIcon={<FavoriteIcon />}
                      ></Button>
                    </Stack>
                  </div>
                </div>
              </Flip>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewFoodUser;
