import React from "react";
import { Link } from "react-router-dom";
import "./ProductCard.css";

export default function ProductCard(props) {


	const handleDelete = () => {

		let text = "Either OK or Cancel.";
		if (window.confirm(text) == true) {
			console.log(props)
			fetch(`https://dummyjson.com/products/${props.product.id}`, {
				method: 'DELETE',
			})
				.then(response => response.json())
				.then(data => {
					props.setProducts(props.products.filter((p => p.id !== props.product.id)))
					console.log('Product deleted successfully:', data);
				})
				.catch(error => {
					console.error('Error deleting product:', error);
				});
		} else {
			alert("You canceled!");
		}
	};


	return (
		<div className="card card-height">
			<img src={props.product.thumbnail} className="card-img-top card-img-height" alt="..." />
			<div className="card-body">
				<h5 className="card-title card-title-line">{props.product.title}</h5>
				<p className="card-text card-description-line">{props.product.description}</p>
				<div className="card-btn-group">
					<Link to={`/product-detail/${props.product.id}`} className="btn btn-primary card-btn card-btn-detail">
						Details
					</Link>
					<button onClick={handleDelete} className="btn btn-danger card-btn card-btn-delete">Sil</button>
				</div>
			</div>
		</div>
	);
}

