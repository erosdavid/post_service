insert into user_post (id, post_text, picture, link, username, post_date) values (1001, 'prvi post tekst', 'slikaa',  'neki link', 'jack1', '2020-12-08 17:11:31');
insert into user_post (id, post_text, picture, link, username, post_date) values (1002, 'drugi post tekst', 'slika2',  'link2', 'jack2', '2020-12-08 17:11:32');
insert into user_post (id, post_text, picture, link, username, post_date) values (1003, 'treci post tekst', 'slika3',  'link3', 'jack3', '2020-12-08 17:11:33');



insert into like_post (id, username, user_post) values (1001, 'jack1', 1001 );



insert into dislike_post (id, username, user_post) values (1001, 'jack2', 1002);



insert into comment (id, comment_text, username, user_post, comment_date) values (1003, 'nekikoment', 'nekijuze2', 1003, '2020-12-08 17:11:34');