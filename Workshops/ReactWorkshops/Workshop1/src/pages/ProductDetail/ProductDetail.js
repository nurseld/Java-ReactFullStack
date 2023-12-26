import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

export default function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);

  useEffect(() => {
    const fetchProductDetail = async () => {
      try {
        const response = await axios.get(`https://dummyjson.com/products/${id}`);
        setProduct(response.data);
      } catch (error) {
        console.error("Error fetching product detail:", error);
      }
    };

    fetchProductDetail();
  }, [id]);

  return (
    <div className="container mt-5">
      {product ? (
          <div className="card" style={{width: "36rem"}}>
          <img src={product.thumbnail} className="card-img-top" alt="..."/>
          <div className="card-body">
            <h5 className="card-title">{product.title}</h5>
            <p className="card-text">{product.description}</p>
          </div>
          <ul className="list-group list-group-flush">
            <li className="list-group-item">{product.price}</li>
            <li className="list-group-item">{product.brand}</li>
            <li className="list-group-item">{product.category}</li>
          </ul>
         
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>



  );
}