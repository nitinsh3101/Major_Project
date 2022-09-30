import React from "react";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import FoodService from "../Services/FoodService";
import "../css/updateUser.css";
import swal from "sweetalert";

const UpdateFood = () => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [deliveryTime, setDeliveryTime] = useState("");
  const { foodId } = useParams();
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    FoodService.getFoodById(foodId).then((res) => {
      setId(res.data?.id);
      setName(res.data?.name);
      setPrice(res.data?.price);
      setCategory(res.data?.category);
      setDeliveryTime(res.data?.deliveryTime);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    let food = {
      id: id,
      name: name,
      price: price,
      category: category,
      deliveryTime: deliveryTime,
    };

    FoodService.updateFood(food, food.id)
      .then((res) => {
        swal({
          title: "Food Edited",
          icon: "success",
          timer: 2000,
          showCancelButton: false,
          showConfirmButton: false,
          buttons: false,
        });
        setTimeout(() => (window.location = "/restOwnerDashboard"), 2000);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="loginbackground">
      <div className="inputback">
        <div class="formback">
          <h1>Edit Food</h1>
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
                Price
              </label>
              <input
                type="text"
                className="form-control"
                id="price"
                value={price}
                onChange={(e) => setPrice(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label for="exampleInputPassword1" className="form-label">
                Category
              </label>
              <input
                type="text"
                className="form-control"
                id="category"
                value={category}
                onChange={(e) => setCategory(e.target.value)}
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

export default UpdateFood;
