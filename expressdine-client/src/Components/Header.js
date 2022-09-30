import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import MenuItem from "@mui/material/MenuItem";
import { ListItemButton } from "@mui/material";
import { Link } from "react-router-dom";
import List from "@mui/material/List";
import ListItemText from "@mui/material/ListItemText";
import { padding } from "@mui/system";

const pages = [
  { name: "Home", url: "/" },
  { name: "About Us", url: "/aboutUs" },
  { name: "Contact Us", url: "/contactUs" },
];
const settings = [
  { name: "Edit Profile", url: "/editUser" },
  { name: "Favourite Food", url: "/viewFavouriteFoodUser" },
  { name: "Favourite Restaurant", url: "/viewFavouriteRestaurantUser" },
  { name: "View Cart", url: "/viewCart" },
  { name: "View Orders", url: "/userOrders" },
  { name: "View Complaints", url: "/viewComplaintUser" },
];

const Header = () => {
  const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);
  const [role] = React.useState(sessionStorage.getItem("role"));
  const [loggedIn, setLoggedIn] = React.useState("false");

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  const logout = () => {
    sessionStorage.clear();
    window.location = "/";
  };

  React.useEffect(() => {
    const userId = sessionStorage.getItem("userId");
    if (userId != null) {
      setLoggedIn("true");
    }
  }, []);

  return (
    <AppBar position="static" style={{ backgroundColor: "black" }}>
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Typography
            variant="h5"
            noWrap
            component="div"
            sx={{ mr: 2, display: { xs: "none", md: "flex" } }}
          >
            ExpressDine
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: "bottom",
                horizontal: "left",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "left",
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: "block", md: "none" },
              }}
            >
              {pages.map((page) => (
                <List>
                  <ListItemButton component={Link} to={page.url}>
                    <ListItemText primary={page.name} />
                  </ListItemButton>
                </List>
              ))}
            </Menu>
          </Box>
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}
          >
            ExpressDine
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" } }}>
            {pages.map((page) => (
              <List
                onClick={handleCloseNavMenu}
                sx={{ my: 0, color: "white", display: "block" }}
              >
                <ListItemButton component={Link} to={page.url}>
                  <ListItemText primary={page.name} />
                </ListItemButton>
              </List>
            ))}
          </Box>

          {`${loggedIn}` == "true" ? (
            <button className="btn btn-dark" onClick={logout}>
              Logout
            </button>
          ) : (
            <div></div>
          )}

          {`${role}` == "user" ? (
                     <Box sx={{ flexGrow: 0 }}>
                     <Tooltip title="Open settings">
                       <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                         <Avatar src="/static/images/ed.png" />
                       </IconButton>
                     </Tooltip>
         
                     <Menu
                       sx={{ mt: "45px" }}
                       id="menu-appbar"
                       anchorEl={anchorElUser}
                       anchorOrigin={{
                         vertical: "top",
                         horizontal: "right",
                       }}
                       keepMounted
                       transformOrigin={{
                         vertical: "top",
                         horizontal: "right",
                       }}
                       open={Boolean(anchorElUser)}
                       onClose={handleCloseUserMenu}
                     >
                       {settings.map((setting) => (
                         <List>
                           <ListItemButton component={Link} to={setting.url}>
                             <ListItemText primary={setting.name} />
                           </ListItemButton>
                         </List>
                       ))}
                     </Menu>
                   </Box>
          ) : (
            <div></div>
          )}
        </Toolbar>
      </Container>
    </AppBar>
  );
};
export default Header;
