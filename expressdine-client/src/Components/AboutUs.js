import React from "react";
import "../css/aboutUs.css";
import pic1 from "../img/Profile1.jpg";
import pic2 from "../img/Profile2.jpg";
import pic3 from "../img/Profile3.jpg";
import pic4 from "../img/Profile4.jpg";

const AboutUs = () => {
  return (
    <div>
      <div className="about-section">
        <h1>Well Come to ExpressDine</h1>
        <p>Here is the best solution for empty stomache and test for tounge.</p>
        <p>Visit once; We are sure you will visit again and again !!!</p>
      </div>

      <h2>Our Team</h2>
      <div className="row">
        <div className="column">
          <div className="card">
            <div className="container">
              <h2>Shubham Mane</h2>
              <img src={pic1} />
              <p className="title">CEO & Founder</p>
              <p>Founded this company on April 2022.</p>
              <p>
                <a href="mailto:shubhamman@cybage.com">shubhamman@cybage.com</a>
              </p>
              <p>
                <button className="button">Contact</button>
              </p>
            </div>
          </div>
        </div>

        <div className="column">
          <div className="card">
            <div className="container">
              <h2>Shubham Gadhave</h2>
              <img src={pic2} />
              <p className="title">Art Director</p>
              <p>The art director of our company to serve you the best !!!</p>
              <p>
                <a href="mailto:shubhamgad@cybage.com">shubhamgad@cybage.com</a>
              </p>
              <p>
                <button className="button">Contact</button>
              </p>
            </div>
          </div>
        </div>

        <div className="column">
          <div className="card">
            <div className="container">
              <h2>Shubham Chavhan</h2>
              <img src={pic3} />
              <p className="title">Manager</p>
              <p>
                Controlling whole the system as a managing director of our
                company.
              </p>
              <p>
                <a href="mailto:shubhamchav@cybage.com">
                  shubhamchav@cybage.com
                </a>
              </p>
              <p>
                <button className="button">Contact</button>
              </p>
            </div>
          </div>
        </div>

        <div className="column">
          <div className="card">
            <div className="container">
              <h2>Shubham Bachkar</h2>
              <img src={pic4} />
              <p className="title">Designer</p>
              <p>Designing Asthetic appearance and prety look to you !!!</p>
              <p>
                <a href="mailto:shubhamba@cybage.com">shubhamba@cybage.com</a>
              </p>
              <p>
                <button className="button">Contact</button>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AboutUs;
