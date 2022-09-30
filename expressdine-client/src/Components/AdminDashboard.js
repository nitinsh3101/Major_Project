import { className } from "@emotion/react";
import { style } from "@mui/system";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Flip from "react-reveal/Flip";
import "../css/admin.css";

const AdminDashboard = () => {
  const [userId] = useState(sessionStorage.getItem("userId"));

  useEffect(() => {
    if (userId == null) {
      window.location = "/";
    }
  }, []);

  return (
    <div>
      <div className="background">
        <div className="row">
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 250, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewRestAdmin">
                    {" "}
                    <button className="btn btn-outline-dark">Restaurant</button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>

          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 250, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/addRest">
                    {" "}
                    <button className="btn btn-outline-dark">
                      Add Restaurant
                    </button>{" "}
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 250, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/addRestaurantOwner">
                    <button className="btn btn-outline-dark">Add Owner</button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 250, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/lockedAccounts">
                    <button className="btn btn-outline-dark">
                      Locked Accounts
                    </button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
          <div className="col">
            <Flip right>
              <div className="card" style={{ width: 250, height: 300 }}>
                <img
                  src="https://png.pngtree.com/template/20190927/ourmid/pngtree-restaurant-icon-logo-design-template-image_312035.jpg"
                  className="card-img-top"
                  alt="..."
                ></img>
                <div className="card-body">
                  <Link className="link" to="/viewFeedback">
                    <button className="btn btn-outline-dark">
                      View Feedback
                    </button>
                  </Link>
                </div>
              </div>
            </Flip>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminDashboard;
