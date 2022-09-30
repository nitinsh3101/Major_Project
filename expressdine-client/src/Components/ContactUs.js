import React from 'react';
import '../css/contactUs.css'

const ContactUs=()=> {
   
  return (
    <div className='loginbackground'>
        <div className="inputback">
          <div class="form">
      <h1 className="">Contact US</h1>
      <hr width="100%" 
        size="10" 
        color="black"
        align="center"></hr>
      <form>
       <div class="inputstyle">
      <input type="text" name="fullname"   class="form-control" id="exampleFormControlInput1" placeholder="Enter your Name.." />
    </div>
    <div class="inputstyle">
      <input type="text"  name="phone"  class="form-control"  id="exampleFormControlInput1" placeholder="Enter Mobile Number.." />
    </div>
    <div class="inputstyle">
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder='Enter Message..'></textarea>
  </div>
  <div className="inputstyle">
  <button type="submit" class="btn btn-primary">Submit form</button>
  </div>
  
      </form> 
     
      </div>  
      </div>
      </div>
  
     
   
  );
}

export default ContactUs;
