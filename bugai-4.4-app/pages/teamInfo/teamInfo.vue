<template>
  <div class="team-introduction" :style="{height:screenHeight+'px'}">
    <div class="teacher-box">
      <h2 class="team-members-title">指导老师</h2>
      <div class="teacher">
        <!-- <img src="./assets/teacher.jpg" class="avatar" /> -->
        <h3 class="name">李萍</h3>
        <p class="description">数学学院</p>
      </div>
    </div>

    <div class="members-box">
      <h2 class="team-members-title">团队成员</h2>
      <div class="members">
        <div v-for="(member, index) in members" :key="index" class="member">
          <!-- <img :src="member.avatar" class="avatar" /> -->
          <h4 class="name">{{ member.name }}</h4>
          <p class="description">{{ member.description }}</p>
        </div>
      </div>
    </div>

    <div class="thanks-box">
      <h4>特别鸣谢：</h4>
      <div v-for="(thanks, index) in specialThanks" :key="index" class="thanks-item">
        <p>{{ thanks }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
		screenHeight: uni.getSystemInfoSync().windowHeight,
      members: [
        {
          name: '龙坤岳',
          avatar: './assets/member-1.jpg',
          description: '数学与应用数学2001',
        },
        {
          name: '龙平',
          avatar: './assets/member-2.jpg',
          description: '软件工程2001',
        },
        {
          name: '王帅',
          avatar: './assets/member-3.jpg',
          description: '数学与应用数学2001',
        },
        {
          name: '谭学轩',
          avatar: './assets/member-4.jpg',
          description: '信息与计算科学2001',
        },
        {
          name: '梁玉卿',
          avatar: './assets/member-5.jpg',
          description: '人工智能2002',
        },
      ],
      specialThanks: [
        '刘晓光(老师)        数学学院',
        '张卜中       软件工程2003',
      ],
    }
  },
}
</script>

<style scoped>
.team-introduction {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
  max-width: 90%;
  padding: 20px;
  text-align: center;
  margin:0px;
  background: url(/static/imgs/teambg.jpg) no-repeat;
  background-size:100% 100%;
  background-attachment:fixed;
}

.teacher-box,
.members-box,
.thanks-box {
  border: 1px solid #ccc;
  border-radius: 10px;
  margin-bottom: 20px;
  padding: 10px;
  width: 100%;
  height: auto;
}

.teacher {
  margin-bottom: 0px;
}

.members {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin-bottom: 0px;
}

.member {
  margin: 10px;
  max-width: 100px;
 display: flex;
	justify-content: center;
	/* align-items: center; */
flex-wrap: wrap;
}

.member .avatar {
  width: 100%;
  border-radius: 50%;
  margin-bottom: 10px;
}

.name {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 10px;
  /* box-sizing: border-box; */
}

.description {
  font-size: 0.8rem;
  line-height: 1.4;
  margin-bottom: 20px;
  /* box-sizing: border-box; */
}

.thanks-item {
  padding: 5px 10px;
  margin: 5px;
  font-size: 0.8rem;
}

.team-members-title {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 20px;
}

/* 媒体查询 */
@media screen and (max-width: 600px) {
  .teacher-box,
  .members-box,
  .thanks-box {
    margin: 10px;
    padding: 5px;
  }

  .teacher {
    margin-bottom: 20px;
  }

  .member {
    max-width: 80px;
  }

  .name {
    font-size: 1rem;
  }

  .description {
    font-size: 0.7rem;
  }

  .thanks-item {
    font-size: 0.7rem;
  }

  .team-members-title {
    font-size: 1.2rem;
    margin-bottom: 10px;
  }
}

</style>
