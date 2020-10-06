import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Home from "@/views/Home.vue";
import LoginView from "@/views/accounts/LoginView.vue";
import SignupView from "@/views/accounts/SignupView.vue";
import MyPageView from "@/views/accounts/MyPageView.vue";
import DetailArtistView from "@/views/detail/DetailArtistView.vue";
import DetailArtView from "@/views/detail/DetailArtView.vue";
import MygalleryView from "@/views/mygallery/MygalleryView.vue";

//recommendation
import RecommendationPage from "@/views/recommendations/RecommendationPage.vue";

//categorys
import CategoryList from "@/views/categorys/CategoryList.vue";
import ArtistList from "@/views/categorys/artists/ArtistList.vue";
import MuseumList from "@/views/categorys/museums/MuseumList.vue";
import StyleList from "@/views/categorys/styles/StyleList.vue";
//userartview
import AmateurArtistView from "@/views/categorys/amateurart/AmateurArtistView.vue";
import AmateurArtView from "@/views/categorys/amateurart/AmateurArtView.vue";
import AmateurArtUpload from "@/views/categorys/amateurart/AmateurArtUpload.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/accounts/login",
    name: "Login",
    component: LoginView
  },
  {
    path: "/accounts/signup",
    name: "Signup",
    component: SignupView
  },
  {
    path: "/accounts/mypage",
    name: "MyPage",
    component: MyPageView
  },
  {
    path: "/artist/:artist",
    name: "DetailArtistView",
    component: DetailArtistView
  },
  {
    path: "/art/:artNo",
    name: "DetailArtView",
    component: DetailArtView
  },
  {
    path: "/mygallery",
    name: "MyGalleryView",
    component: MygalleryView
  },
  //category
  {
    path: "/categorys/categorylist",
    name: "CategoryList",
    component: CategoryList
  },
  {
    path: "/categorys/artistlist",
    name: "ArtistList",
    component: ArtistList
  },
  {
    path: "/categorys/museumlist",
    name: "MuseumList",
    component: MuseumList
  },
  {
    path: "/categorys/stylelist",
    name: "StyleList",
    component: StyleList
  },
  {
    path: "/recommend",
    name: "RecommendView",
    component: RecommendationPage
  },
  {
    path: "/categorys/amateurartist",
    name: "AmateurArtistView",
    component: AmateurArtistView
  },
  {
    path: "/categorys/amateurart",
    name: "AmateurArtView",
    component: AmateurArtView
  },
  {
    path: "/amateur/upload",
    name: "AmateurArtUpload",
    component: AmateurArtUpload
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
