function add_to_cart(pid, pName, pPrice) {
	let cart = localStorage.getItem("cart");
	let products = [];
	if (cart == null) {
		//no cart yet 
		let product = { productId: pid, productName: pName, productPrice: pPrice, productQuantity: 1 }
		products.push(product);
		localStorage.setItem("cart", JSON.stringify(products));
		console.log("product added for the first time");
	} else {
		//cart is already present
		let pcart = JSON.parse(cart);
		let oldproduct = pcart.find((item) => item.productId == pid)
		console.log(oldproduct);
		if (oldproduct) {
			//increase product quantity
			oldproduct.productQuantity = oldproduct.productQuantity + 1;
			pcart.map((item) => {
				if (item.productId == oldproduct.productId) {
					item.productQuantity = oldproduct.productQuantity;
				}
			})
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("productquatity increased  ");

		} else {
			//add new product
			let product = { productId: pid, productName: pName, productPrice: pPrice, productQuantity: 1 }
			pcart.push(product);
			localStorage.setItem("cart", JSON.stringify(pcart));
			console.log("new product added ");


		}
	}
	updateCart();
}

//update cart
function updateCart() {
	let cartString = localStorage.getItem("cart");
	let cart = JSON.parse(cartString);
	if (cart== null || cart.length == 0) {
		console.log("cart is empty by payal");
		$(".cartText").html("Cart is empty");
		$(".cart-items").html("(0)");
		$(".btn-checkout").addClass('disabled');
	} else {
		//cart is not empty
		console.log("helloo___"+cart);
		$(".cart-items").html(`(${cart.length})`);
				$(".btn-checkout").removeClass('disabled');

		let table = `
					<table class='table'>
					<thead class='thead-light'>
					<tr>
						<th>Item Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Action</th>

					</tr>
					</thead>
					`;
		let totalPrice = 0;
		cart.map((item) =>{
			table +=  `
						<tr>
						<td>${item.productName}</td>
									<td>${item.productPrice}</td>
									<td>${item.productQuantity}</td>
									<td>${item.productPrice * item.productQuantity}</td>
									<td><button class="btn btn-danger btn-sm" onClick='removeItem(${item.productId})'>remove</button></td>
								</tr>`
								
								totalPrice +=item.productPrice * item.productQuantity	
									
									})



	table = table +`
				
				<tr><td colspan='5' class="text-right font-weight-bold m-5 ">Total Price: ${totalPrice}</td></tr>
				</table>`
	$(".cartText").html(table);


}
}

//Remove item from cart 
function removeItem(pId){
	let cart = JSON.parse(localStorage.getItem('cart'));
	let newCart = cart.filter((item)=>item.productId!=pId);
	localStorage.setItem('cart',JSON.stringify(newCart));
	updateCart();
}

$(document).ready(function() {

	updateCart();
	// more code here if needed, etc.
});

//send to checkOut page
function checkoutPage(){
	window.location="checkout.jsp";
}

//send to update page
function updateProfilePage(){
	window.location="updateProfile.jsp";
}