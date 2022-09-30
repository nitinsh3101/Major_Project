import React, { useEffect } from "react";
import { useState } from "react";
import FoodService from "./../Services/FoodService";
import "../css/viewRestAdmin.css";

const AddFood = () => {
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [deliveryTime, setDeliveryTime] = useState("");
  const [userId] = useState(sessionStorage.getItem("userId"));


  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  },[])

  const handleSubmit = (e) => {
    e.preventDefault();

    let food = {
      name: name,
      price: price,
      category: category,
      deliveryTime: deliveryTime,
      restaurant: {
        id: 1,
      },
    };

    FoodService.addFood(food)
      .then((res) => {
        console.log("hellooooo");
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="loginbackground">
    <div className="inputback">
   <div class="formbackg">
        <h1>Add Food</h1>
        <hr width="100%" 
        size="10" 
        color="black"
        align="center"></hr>
        <form onSubmit={handleSubmit}>
          <div className="inputstyle">
            
            <input
              type="text"
              className="form-control"
              id="name"
              value={name}
              placeholder="Food Name.."
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="inputstyle">
            <input
              type="text"
              className="form-control"
              id="price"
              value={price}
              placeholder="Enter Price.."
              onChange={(e) => setPrice(e.target.value)}
            />
          </div>
          <div className="inputstyle">
            <input
              type="text"
              className="form-control"
              id="category"
              value={category}
              placeholder="Enter Category.."
              onChange={(e) => setCategory(e.target.value)}
            />
          </div>
          <div className="inputstyle">
            <input
              type="text"
              className="form-control"
              id="deliveryTime"
              placeholder="Preparation Time"
              value={deliveryTime}
              onChange={(e) => setDeliveryTime(e.target.value)}
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

export default AddFood;
