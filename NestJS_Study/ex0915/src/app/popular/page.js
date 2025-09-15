"use client"
import { useState } from "react";
import "../globals.css"

function Page(){
    // const [cnt,setCnt]= useState(0);
    const [cnt,setCnt]= useState([0,0,0]);
    let title ="인기과목";
    let item = [
        { name: "자바 바이블 예제", date: "2025-09-01" ,imag: "/images/book1.png"},
        { name: "스프링 용어집", date: "2025-09-02",imag: "/images/book2.png"},
        { name: "AI 활용", date: "2025-09-03",imag: "/images/book3.png" }
    ];

    return(
        <div>
            <h1 className="title">{title}</h1>
            <hr/>
            {
                item.map((item,i)=>(
                    <div className="box" key={i}>
                        <header>
                            <h4>{item.name}</h4>
                            <p>{item.date}</p>
                            <img src={`/images/book${i+1}.png`} className="box-img" alt={item.name}/>
                            <div className="fr">
                                <span>{cnt[i]}</span>
                                <button onClick={function(){

                                    //일단 useState의 값을 복사해온다.
                                    let cnt2=[...cnt];//cnt의 내용 복사
                                    //cnt2는 cnt가 기억하고 있는 숫자 3개짜리
                                    //배열을 그대로 복사받는다. 즉,[0,0,0]
                                    cnt2[i]=cnt2[i]+1;
                                    setCnt(cnt2);
                                    }}>+</button>
                            </div>
                        </header>
                    </div>
                ))
            }
        </div>
    );
}
export default Page;
