drop database if exists `youtube_clone`;

create database if not exists `youtube_clone`;

use `youtube_clone`;

--
-- Table structure for table `User`
--



drop table if exists `user`;
create table `user` (
`id` binary(16) not null,
 `createdAt` datetime,
 `username` varchar(50) not null unique,
 `email` varchar(50) not null unique,
 `avatar` varchar(255) default null,
 `cover` varchar(255) default null,
 `videos` binary(16) default null,
 `subscriber` binary(16) default null,
 `subscribed` binary(16) default null,
-- reference do not uncomment 
-- foreign key (`subscriber`) references subscriber(`id`);
-- foreign key (`subscribed`) references subscribed(`id`);
primary key(`id`)
);

-- DELIMITER #
-- create trigger `insert_user`
-- before insert on `user`
-- for each row
-- begin
-- 	set new.id = uuid();
-- end#
-- DELIMITER ;





--
-- Table structure for table `comment`
--

drop table if exists `comment`;
create table `comment` (
`id` binary(16) not null,
`createdAt` datetime default current_timestamp,
`text` varchar(250) not null,
`userId` binary(16) not null,
`videoId` binary(16) not null,
-- reference do not uncomment 
-- foreign key (`userId`) references user(`id`),
-- foreign key (`videoId`) references video(`id`),
primary key(`id`)
);

--
-- Table structure for table `subscription`
--

drop table if exists `subscription`;
CREATE TABLE `subscription` (
    `id` BINARY(16) NOT NULL,
    `subscriber` BINARY(16) NOT NULL,
    `subscribed` BINARY(16) NOT NULL,
    KEY (`subscriber`),
    KEY (`subscribed`),
    PRIMARY KEY (`id`)
);

--
-- Table structure for table `video`
--


drop table if exists `video`;
create table `video` (
`id` binary(16) not null,
`createdAt` datetime default current_timestamp,
`title` varchar(50) not null,
`description` varchar(250) not null,
`url` varchar(250) not null,
`thumbnail` blob not null,
`userId` binary(16) not null,
`videoLikes` binary(16) default null,
`views` binary(16) default null,
-- reference do not uncomment 
-- foreign key (`userId`) references user(`id`),
primary key(`id`)
);

--
-- Table structure for table `videolike`
--

drop table if exists `videoLike`;
create table `videoLike` (
`id` binary(16) not null,
`createdAt` datetime default current_timestamp,
`like` int default 0,
`userId` binary(16),
`videoId` binary(16),
-- reference do not uncomment 
-- foreign key (`userId`) references user(`id`),
-- foreign key (`videoId`) references video(`id`),
primary key(`id`)
);


--
-- Table structure for table `view`
--

drop table if exists `view`;
create table `view` (
`id` binary(16) not null,
`createdAt` datetime default current_timestamp,
`userId` binary(16) not null,
`videoId` binary(16) not null,
-- reference do not uncomment 
-- foreign key (`userId`) references user(`id`),
-- foreign key( `videoId`) references video(`id`),
primary key(`id`)
);



--
-- Add foreign keys to table `user`
--

alter table `user` add foreign key (`subscriber`) references subscription(`subscriber`);
alter table `user` add foreign key (`subscribed`) references subscription(`subscribed`);
alter table `user` add foreign key (`videos`) references video(`id`);


--
-- Add foreign keys to table `comment`
--

alter table `comment` add foreign key (`userId`) references user(`id`);
alter table `comment` add foreign key (`videoId`) references video(`id`);

--
-- Add foreign keys to table `subscription`
--

alter table `subscription` add foreign key (`subscriber`) references user(`id`);
alter table `subscription` add foreign key (`subscribed`) references user(`id`);

--
-- Add foreign keys to table `video`
--

alter table `video` add foreign key (`userId`) references user(`id`);
alter table `video` add foreign key (`videoLikes`) references videoLike(`id`);
alter table `video` add foreign key (`views`) references view(`id`);

--
-- Add foreign keys to table `videoLike`
--

alter table `videoLike` add foreign key (`userId`) references user(`id`);
alter table `videoLike` add foreign key (`videoId`) references video(`id`);

--
-- Add foreign keys to table `view`
--

alter table `view` add foreign key (`userId`) references user(`id`);
alter table `view` add foreign key( `videoId`) references video(`id`);




