import { create } from "zustand";

const TokenStroe = create((set) => ({
  accessToken: null,
  setToken(token){
    set({accessToken:token});
  },
}));

export default TokenStroe;