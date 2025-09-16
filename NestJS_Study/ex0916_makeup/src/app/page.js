"use client";

import Image from "next/image";
import styles from "./page.module.css";
import axios from "axios";
import { useEffect, useState } from "react";
import ItemList from "@/components/ItemList";
import { Divider } from "@mui/material";

export default function Home() {
  const api_url="/api/v1/products.json?brand=maybelline";

  const[list,setList] =useState([]);
  function callApi(){
    //비동기식 통신
    axios.get(api_url).then(function(data){
      console.log(data.data);
      setList(data.data);

    });
  }

  useEffect(function(){
    callApi();
  },[]); //현재 페이지가 읽혀질때 한번 호출함

  return (
    <div className={styles.page}>

          <div style={{width:'80%',margin:'auto',padding:'20px'}}>
            <h2>베스트 상품</h2>
            <Divider/> {/*구분선 */}
            <ItemList list={list.slice(0,9)}/>
            <h2>신상품</h2>
            <Divider/> {/*구분선 */}
            <ItemList list={list.slice(9)}/>
        </div>

    </div>
  );
}
