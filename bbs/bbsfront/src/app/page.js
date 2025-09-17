import styles from "./page.module.css";
import { Divider } from "@mui/material";

export default function Home() {
  return (
        <div className={styles.page}>

      <div style={{width:'90%',margin:'auto',padding:'20px'}}>
      <h1>sist 연습페이지</h1>
      <Divider/>
      </div>
    </div>
  );
}
