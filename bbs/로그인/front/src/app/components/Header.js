import Link from "next/link";

export default function Header(){

    return(
        <div>
            <div className="navBar">
                <Link href="/">Home</Link>
                <Link href="/members">Members</Link>
                <Link href="/bbs">Board</Link>
            </div>
            <div className="fr">
                <Link href="/members/login">Login</Link>
                <Link href="/members/signup">Signup</Link>
            </div>
        </div>
    );
  };