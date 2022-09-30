import React, { useEffect, useState } from "react";
import CartService from "../Services/CartService";
import "../css/viewCart.css";
import OrderService from "../Services/OrderService";
import DeleteIcon from "@mui/icons-material/Delete";
import Button from "@mui/material/Button";
import swal from "sweetalert";

const ViewCart = () => {
  const [cartList, setCartList] = useState([]);
  const [quantity, setQuantity] = useState();
  const [totalAmount, setTotalAmount] = useState(0);
  const [userId] = useState(sessionStorage.getItem("userId"));


  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }

    let total = 0;
    CartService.getCartItems(userId).then((response) => {
      response.data.map((cart) => {
        total = total + cart.food.price * cart.quantity;
      });
      setTotalAmount(total);
      setCartList(response.data);
    });
  }, []);

  const handleQuantity = (quantity, cartItem) => {
    let cart = {
      id: cartItem.id,
      quantity: quantity,
      amount: cartItem.amount,
      food: {
        id: cartItem.food.id,
      },
      user: {
        id: userId,
      },
    };

    CartService.changeQuantity(cart).then((res) => {
      console.log(res);
    });
  };

  const removeItem = (cartId) => {
    CartService.removeItem(cartId).then((res) => {
      window.location = "/viewCart";
    });
  };

  const placeOrder = () => {
    swal({
      title: "Order is getting placed",
      icon: "info",
      timer: 9000,
      showCancelButton: false,
      showConfirmButton: false,
      buttons: false,
    });
    OrderService.placeOrder(userId).then((res) => {
      window.location = "/userOrders";
    });
  };

  return (
    <div>
      <h2> Total amount : {totalAmount}</h2>

      <button className="btn btn-outline-success" onClick={placeOrder}>
        Place Order
      </button>
      <div className="design">
      {cartList.map((cart) => (
        <div className="card" >
          <img className="card-img-top" src="https://png.pngtree.com/png-vector/20190507/ourmid/pngtree-vector-food-icon-png-image_1024923.jpg" alt="Card image cap" />
          <div className="card-body1 ">
            <h5 className="card-title">{cart.food.name}</h5>
            <p className="card-text">{cart.food.price}</p>
          </div>
          <ul className="list-group list-group-flush">
            <li className="list-group-item"> Category : {cart.food.category}</li>
            <li className="list-group-item">
              Preparing Time :{cart.food.deliveryTime} hr
            </li>
            <li className="list-group-item">
              Quantity : {cart.quantity}
              <form className="form1">
                <input
                  type="number"
                  className="form-control"
                  id="quantity"
                  onChange={(e) => setQuantity(e.target.value)}
                />
                <button
                  className="btn btn-outline-info my-2"
                  type="submit"
                  onClick={() => handleQuantity(quantity, cart)}
                >
                  Ok
                </button>
              </form>{" "}
            </li>
          </ul>
          <div className="card-body1">
            <Button
              variant="outlined"
              onClick={() => removeItem(cart.id)}
              color="error"
              startIcon={<DeleteIcon />}
            ></Button>
          </div>
        </div>
      ))}
    </div>
    </div>
  );
};

export default ViewCart;
