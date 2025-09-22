"use client"

import Link from "next/link";
import TokenStore from "@/app/stroe/TokenStore";
import { useRouter } from "next/navigation";
import axios from "axios";

export default function Header(){
    // const cookieStroe = await cookies();
    // const accessToken = cookieStroe.get("accessToken")?.value; 이건 요청시점의 쿠키만 받아옴
    //cookieStroe.get("accessToken")의 값이 있으면 accessToken변수애
    //쿠키에 있는 "accessToken"값이 저장되지만 없으면 undefuined가 저장된다.

    //상태관리에 필요한 객체 준비
    //쿠키로 넘어오는얘를 담은게 아니라 로그인에 있는 setToken에서 서버가 나한테 넘겨준
    //json을 담은거임
    const {accessToken,setToken} = TokenStore();
    const api_url="/api/members/logout";
    const router = useRouter();

    function logout(){
        //컨펌을 받자@@
        if(confirm("로그아웃 하시겠습니까?")){
            axios.post(
                api_url, {}, // body 비워서 전송
                {
                    withCredentials: true, // 쿠키를 포함해서 보내야 함
                    headers:{
                        "Content-Type":"application/json"
                    }
                }
            ).then(function(res){
                if(res.status==200 && res.data.msg == "logout"){
                    setToken(null);//zustand의 값을 null로 지우는것
                    router.push("/");
                }
            });
        }
    }

    return(
        <div>
            <div className="navBar">
                <Link href="/">Home</Link>
                <Link href="/members">Members</Link>
                <Link href="/bbs">Board</Link>
            </div>
            <div className="fr">
            {//로그인 로그아웃
                accessToken ==null?
                <Link href="/members/login">Login</Link>:
                //Link 대신 아래처럼도 해보기
                <button onClick={logout}>Logout</button>
            }
                <Link href="/members/signup">Signup</Link>
            </div>
        </div>
    );
}
