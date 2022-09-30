import DeleteIcon from "@mui/icons-material/Delete";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import Button from "@mui/material/Button";
import Stack from "@mui/material/Stack";
import React, { useEffect, useState } from "react";
import Flip from "react-reveal/Flip";
import swal from "sweetalert";
import "../css/viewRestAdmin.css";
import FoodService from "../Services/FoodService";

function ViewFoodRestOwner() {
  const [userId] = useState(sessionStorage.getItem("userId"));
  const [foodList, setFoodList] = useState([]);

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    FoodService.getAllFoodByOwner(userId).then((res) => {
      setFoodList(res.data);
    });
  }, []);

  const deleteFood = (id) => {
    FoodService.deleteFood(id).then((response) => {
      swal({
        title: "Food deleted",
        icon: "success",
        timer: 2000,
        showCancelButton: false,
        showConfirmButton: false,
        buttons: false,
      });
      setTimeout(() => (window.location = "/viewFoodRestOwner"), 2000);
    });
  };

  const updateFood = (food) => {
    window.location = `/editFood/${food.id}`;
  };

  return (
    <div class="loginbackground">
      <div className="layout">
        {foodList.map((food) => (
          <Flip right>
            <div class="card" style={{ width: 270, padding: 15 }}>
              <img
                src="https://png.pngtree.com/png-vector/20190507/ourmid/pngtree-vector-food-icon-png-image_1024923.jpg"
                class="card-img-top"
                alt="..."
              ></img>

              <div class="card-body">
                <h2 class="card-title">{food.name}</h2>
                <p> Price: {food.price}</p>
                <hr />
                <p> Category: {food.category}</p>
                <hr />
                <p> Deliver In: {food.deliveryTime} Hr</p>
                <hr />
                <Stack direction="row" spacing={2} justifyContent={"center"}>
                  <Button
                    variant="outlined"
                    onClick={() => deleteFood(food.id)}
                    color="error"
                    startIcon={<DeleteIcon />}
                  ></Button>
                  <Button
                    variant="outlined"
                    onClick={() => updateFood(food)}
                    endIcon={<ModeEditIcon />}
                  ></Button>
                </Stack>
              </div>
            </div>
          </Flip>
        ))}
      </div>
    </div>
  );
}

export default ViewFoodRestOwner;
