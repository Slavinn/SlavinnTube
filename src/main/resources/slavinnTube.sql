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
 `username` varchar(50) default null unique,
 `email` varchar(50) not null unique,
 `avatar` blob default null,
 `cover` blob default null,
 `videos` binary(16) default null,
 `subscribers` binary(16) not null,
 `subscribedTo` binary(16) not null,
-- reference do not uncomment 
-- foreign key (`subscribers`) references subscriber(`id`);
-- foreign key (`subscribedTo`) references subscribedTo(`id`);
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
create table `subscription` (
`subscriberId` binary(16),
`subscribedToId` binary(16),
-- reference do not uncomment 
-- foreign key (`subscriberId`) references user(`id`),
-- foreign key (`subscribedTo`) references user(`id`),
key(`subscriberId`),
key(`subscribedToId`)
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
`videoLikes` int default 0,
`views` int default 0,
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

alter table `user` add foreign key (`subscribers`) references subscription(`subscriberId`);
alter table `user` add foreign key (`subscribedTo`) references subscription(`subscribedToId`);

--
-- Add foreign keys to table `comment`
--

alter table `comment` add foreign key (`userId`) references user(`id`);
alter table `comment` add foreign key (`videoId`) references video(`id`);

--
-- Add foreign keys to table `subscription`
--

alter table `subscription` add foreign key (`subscriberId`) references user(`id`);
alter table `subscription` add foreign key (`subscribedToId`) references user(`id`);

--
-- Add foreign keys to table `video`
--

alter table `video` add foreign key (`userId`) references user(`id`);

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




