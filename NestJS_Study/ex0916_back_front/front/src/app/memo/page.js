"use client"
import { Card, CardContent, Divider } from "@mui/material";
import axios from "axios";
import Link from "next/link";
import { useEffect, useState } from "react";

export default function Page() {

    const api_url ="/memo/all";

    const[list,setList] = useState([]);
    function callAPI(){
        axios.get(api_url).then(function(response){
            setList(response.data.m_list);
        });

    }
    useEffect(()=>{ //익명함수
        callAPI();
    },[]) //현재 페이지가 열릴때 한번 수행함 뭐때문에? []이거때문에
    return(
        <div className="list-bg">
            <h2>메모장</h2>
            <Divider/>
            <Card style={{width: '500px',margin:'20px auto'}}>
                <CardContent>
                    {list.map((item,i)=>(
                        <Link key={i} href={`/view/${item.idx}`}>
                            <div className="list-item">
                                <h4 className="item-list-h4">{item.writer}</h4>
                                <p className="item-list-p">{item.content}/{item.reg_date}</p>
                            </div>
                        </Link>
                        )
                    )}
                </CardContent>
            </Card>

        </div>
    );

};
