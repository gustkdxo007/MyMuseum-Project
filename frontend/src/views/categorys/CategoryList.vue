<template>
  <div>
    <!-- 윗공간 -->
    <v-responsive class="mx-auto mb-12" width="56">
      <v-divider class="mb-1"></v-divider>
      <v-divider></v-divider>
    </v-responsive>
    <!-- 제목 -->
    <v-container>
      <h2
        class="display-2 font-weight-bold mb-3 text-uppercase text-center"
        style="color:white"
      >
        Category
      </h2>
      <!-- 아랫공간 -->
      <v-responsive class="mx-auto mb-12" width="56">
        <v-divider class="mb-1"></v-divider>
        <v-divider></v-divider>
      </v-responsive>
      <!-- 분류 -->
      <v-row>
        <v-col
          v-for="({ title, link, hero }, i) in articles"
          :key="i"
          cols="12"
          md="3"
          style="padding: 20px"
        >
          <v-hover v-slot:default="{ hover }">
            <v-card
              flat
              tile
              :elevation="hover ? 12 : 2"
              :class="{ 'on-hover': hover }"
              @click="moveCategory(link)"
            >
              <v-img
                :src="require(`@/assets/dummydata/category/${hero}`)"
                class="mb-4 category-card"
                height="420"
                max-width="100%"
                @mouseenter="zoomIn"
                @mouseleave="zoomOut"
              >
                <v-expand-transition>
                  <div
                    v-if="hover"
                    class="d-flex transition-fast-in-fast-out darken-2 v-card--reveal display-2 white--text black"
                    style="height: 100%;"
                  >
                    {{ title }}
                  </div>
                </v-expand-transition>
              </v-img>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";

import { namespace } from "vuex-class";
const artistModule = namespace("artistModule");
const museumModule = namespace("museumModule");
const amateurModule = namespace("amateurModule");

@Component({
  components: {}
})
export default class CategoryView extends Vue {
  @artistModule.Mutation SET_ARTIST_SEARCHTEXT: any;
  @museumModule.Mutation SET_MUSEUM_SEARCHTEXT: any;
  @amateurModule.Mutation SET_AMATEUR_SEARCHTEXT: any;

  key = "";

  data() {
    return {
      articles: [
        {
          title: "Artist",
          link: "ArtistList",
          hero: "artist.jpg"
        },
        {
          title: "Museum",
          link: "MuseumList",
          hero: "museum.jpg"
        },
        {
          title: "Style",
          link: "StyleList",
          hero: "style.jpg"
        },
        {
          title: "Amateur",
          link: "AmateurArtistView",
          hero: "amateur.jpg"
        }
      ]
    };
  }

  moveCategory(link: string) {
    this.SET_ARTIST_SEARCHTEXT("");
    this.SET_MUSEUM_SEARCHTEXT();
    this.SET_AMATEUR_SEARCHTEXT();
    this.$router.push({
      name: link
    });
  }

  zoomIn(event: any) {
    event.target.style.transform = "scale(1.1)";
    event.target.style.zIndex = 1;
    event.target.style.transition = "all 0.5s";
  }

  zoomOut(event: any) {
    event.target.style.transform = "scale(1)";
    event.target.style.zIndex = 0;
    event.target.style.transition = "all 0.5s";
  }
}
</script>

<style scoped>
.v-card {
  transition: opacity 0.4s ease-in-out;
}

.v-card:not(.on-hover) {
  opacity: 0.9;
  transition: 0.5s;
  transform-origin: center;
  -webkit-box-reflect: below 1px liner-gradient(transparent, transparent, #000f);
}

.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: 0.5;
  position: absolute;
  width: 100%;
}

.category-card {
  box-shadow: 0px 0px 10px 10px;
}
</style>
