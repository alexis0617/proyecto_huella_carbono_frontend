import React from 'react'
import {Navbar,Container,Nav} from "react-bootstrap"
import logoUniversidad from "../images/logoUniversidad.png";


function NavigationMenu(props) {
    return (
        <>
        <Navbar bg="success" className="d-flex" id="main-navbar" expand="lg">
            <Container>
            <Navbar.Brand href="#home">
            <img
            alt=""
            src={logoUniversidad}
            width="70"
            height="80"
            className="d-inline-block align-top"
            />{' '}
            </Navbar.Brand>
                <Navbar.Toggle  aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link href="#home">Inicio</Nav.Link>
                    <Nav.Link href="#link">Iniciar Sesión</Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
</Navbar>
        </>
    )
}

export default NavigationMenu
