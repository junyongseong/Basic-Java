"use client"

import Item from "@/components/Item";
import axios from "axios";
import { use, useEffect, useState } from "react";

export default function Page({params}){
    // const id = params.id;
    // const id = `${params.id}`;
    const {id} = use(params);

    const api_url= `/api/v1/products/${id}.json`;//여기까진 json데이터

    const[vo,setVO] = useState({});

    //비동기식 통신을 수행하기위해 function 하나 만들기
    function getData(){
        axios.get(api_url).then(function(res){
            setVO(res.data);//res가 가지고 있는 data를 setVo에 저장해달라
        });
    }
    //이놈은 딱 한번만 수행하는게 아니라 id가 바뀔때마다 수행해야함
    //여기 [] 배열에 아깐 아무것도 안넣었음 하지만 지금은 넣어야함 그이유는
    //현재 문서에 id변수 값이 변경될때마다 getData함수 호출
    useEffect(function(){
        if(id && id>0)
            getData();
    },[id]);


    return(
        <div style={{width:'80%',margin:'auto',padding:'20px'}}>
            <Item item={vo}/>
        </div>
    );
};