import React from "react";
import { Link } from "react-router-dom";
import "./ProductCard.css";
import { HttpStatusCode } from "axios";

export default function ProductCard(props) {

	const deleteProduct = async () => {

		fetch(`https://dummyjson.com/products/${props.product.id}`, {
			method: 'DELETE',
		})
			.then(response => response.json())
			.then(data => {
				props.onDelete(props.product.id);
				alert("Veri başarıyla silindi.");
				console.log('Product deleted successfully:', data);
			})
			.catch(error => {
				console.error('Error deleting product:', error);
			});

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
					<button onClick={deleteProduct} className="btn btn-danger card-btn card-btn-delete">Sil</button>
				</div>
			</div>
		</div>
	);
}