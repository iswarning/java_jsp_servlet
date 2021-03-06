<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Shoes</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Manager Account</a>
                        </li>
                        <c:if test="${sessionScope.userLogged != null}">
                        	<li class="nav-item">
                            	<a class="nav-link" href="profile">${sessionScope.userLogged.name}</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link" href="logout">Logout</a>
	                        </li>
                        </c:if>
                        <c:if test="${sessionScope.userLogged == null}">
                        	<li class="nav-item">
	                            <a class="nav-link" href="register">Register</a>
	                        </li>
	                        <li class="nav-item">
	                            <a class="nav-link" href="login">Login</a>
	                        </li>
                        </c:if>
                        
                    </ul>

                    <form action="search" method="get" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="q" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search..." value="${key}">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="cart?action=list">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${sessionScope.cart.size()}</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Si??u th??? gi??y ch???t l?????ng cao</h1>
                <p class="lead text-muted mb-0">Uy t??n t???o n??n th????ng hi???u v???i h??n 10 n??m cung c???p c??c s???n ph???m gi??y nh???p t??? Trung Qu???c</p>
            </div>
        </section>
        <!--end of menu-->