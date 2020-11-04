\COPY celestial FROM 'celestial-20141006-001.csv' DELIMITER ';' CSV;
\COPY aspect FROM 'aspect-1-20141006-001.csv' DELIMITER ';' CSV;
\COPY aspect FROM 'aspect-2-20141006-001.csv' DELIMITER ';' CSV;
\COPY aspect FROM 'aspect-3-20141006-001.csv' DELIMITER ';' CSV;
\COPY aspect FROM 'aspect-4-20141006-001.csv' DELIMITER ';' CSV;

UPDATE celestial
   SET name = 'sun',
       description = 'Sun - The Sun tells us of the actual core of a person, the inner self, of that which is of central concern. It also shows us the general vitality and the ability to assert oneself, it describes a general tone of being which colors everything else.  
Sign equivalent: Leo
Diameter: 1''390''000 km.
The Earth''s orbit from Sun: 149''600''000km
Periode Earth - Sun: 365.25 Days',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 1;

UPDATE celestial
   SET name = 'moon',
       description = 'Moon - The Moon represents our feelings and emotions, the receptivity, imagination and basic feeling tone of a person. It also has an effect on the sense of rhythm, time and timing, it influences our adaptability to change, our mobility and versatility.  
Sign equivalent: Cancer
Orbit from Earth: 384''000km
Period: 27.32 Days',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 2;

UPDATE celestial
   SET name = 'mercure',
       description = 'Mercury - Mercury represents reason, reasonableness (common sense), that which is rational. It stands for the spoken and written word, putting in order, weighing and evaluating, the process of learning and skills.  
Sign equivalents: Gemini and Virgo
Orbit from Sun: 57''910''000 km
Period: 88 Days',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 3;

UPDATE celestial
   SET name = 'venus',
       description = 'Venus - Venus gives us a sense of beauty, the enjoyment of pleasure, aesthetic awareness, love of harmony, sociability, taking pleasure in relationships and eroticism.  
Sign equivalents: Libra and Taurus
Orbit from Sun: 108''200''000 km
Period: 225 Days',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 4;

UPDATE celestial
   SET name = 'mars',
       description = 'Mars - Mars represents the energy and drive of a person, their courage, determination, the freedom of spontaneous impulse. It also describes the readiness for action, the way one goes about doing things as well as simple aggression.  
Sign equivalent: Aries
Orbit from Sun: 227''940''000 km
Period: 1,9 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 5;

UPDATE celestial
   SET name = 'jupiter',
       description = 'Jupiter - The search for individual meaning and purpose, optimism, hope and a sense of justice are represented by Jupiter. So also faith, a basic philosophy of life, the striving for spiritual growth and expansion.  
Sign equivalent: Sagittarius
Orbit from Sun: 778''330''000 km
Period: 11,9 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 6;

UPDATE celestial
   SET name = 'saturn',
       description = 'Saturn - Saturn shows how we experience "reality", where we meet with resistance and discover our limitations. It represents the conscience and moral conviction, the laws and rules which we choose to obey. It also tells us about  our powers of endurance and the ability to concentrate, it lends qualities like earnestness, caution and reserve.  
Sign equivalent: Capricorn
Orbit from Sun: 1''429''400''000 km
Period: 29,5 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 7;

UPDATE celestial
   SET name = 'uranus',
       description = 'Uranus - Uranus stands for intuition, it transmits sudden inspiration and lightning insights. An openness for all that is new, unknown and unusual. A sort of wrong-headed contrariness is also associated with this planet. It is said to be characteristic of astrology as such.  
Sign equivalent: Aquarius
Orbit from Sun: 2''870''990''000 km
Period: 84 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 8;

UPDATE celestial
   SET name = 'neptune',
       description = 'Neptune - This planet gives us the supersensory, opens doors to mystical experience and the transcendental. On this level it is hard to discern where perception moves into deception, illusion and false appearances, and so Neptune is associated with all of these, with drugs and all kinds of pseudo-realities.  
Sign equivalent: Pisces
Orbit from Sun: 4''504''300''000 km
Period: 165 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 9;

UPDATE celestial
   SET name = 'pluto',
       description = 'Pluto - Pluto describes how we deal with power, personal and non-personal, be it through suffering the power of others or exercising it ourselves. It describes how we meet the demonic and magical, our regenerative powers and our capacity for radical change and rebirth: the cycles of dying and becoming.  
Sign equivalent: Scorpio
Orbit from Sun: 5''913''520''000 km
Period: 248 Years',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 10;

UPDATE celestial
   SET name = 'first_house',
       description = '1st House (Ascendant) - The individual personality 
Together with the Sun and Moon the ascendant is one of the most important single factors in a horoscope. The sign at the beginning of the first house tells us a lot about someone''s personality, temperament and constitution. It typifies our immediate, instinctive reaction and shows how we present ourselves to the world. The planet ruling the ascendant sign is of particular importance for the interpretation. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 11;

UPDATE celestial
   SET name = 'second_house',
       description = '2nd House - Values and Possessions 
The second house and its occupants tell us about the material circumstances, the acquisitive urge and how we deal with possessions and material means. This includes the relationship to our own body. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 12;

UPDATE celestial
   SET name = 'third_house',
       description = '3rd House - Communication 
The third house and any planets occupying it tell us of our siblings, the manner in which we communicate on an everyday level and the relationships which determine our daily life. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 13;

UPDATE celestial
   SET name = 'fourth_house',
       description = '4th House - Roots and Origins 
This house describes our origins, the parental home and the circumstances influencing childhood and youth. It describes how we relate to family, our attitude towards hearth and home. The father image and the relationship to the real father are also to be found here. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 14;

UPDATE celestial
   SET name = 'fifth_house',
       description = '5th House - Pleasure and Creativity 
Sexuality and eroticism are at home here, along with play in general and all types of creative expression. This house also describes how we relate to children, pleasure and simple fun. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 15;

UPDATE celestial
   SET name = 'sixth_house',
       description = '6th House - Work and Routine
The sixth house describes the circumstances surrounding us in our daily lives, including the work environment and daily routine. This includes our behaviour towards subordinates. Bodily hygiene and care also belong here, as well as tendencies to certain acquired illnesses. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 16;

UPDATE celestial
   SET name = 'seventh_house',
       description = '7th House - Relating 
The descendant sign and planets occupying the seventh house tell us about how we select our partners and describes the partnerships and relationships we seek. Often we are involuntarily attracted to people whose horoscopes carry a strong emphasis of the sign in our seventh house. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 17;

UPDATE celestial
   SET name = 'eighth_house',
       description = '8th House - Loss and Common Property 
The eighth house shows how we relate to communal goods and how we deal with material loss. The taxes levied on us each year are a good example for this and show how closely related these areas are. Traditional astrology maintains that this house has an affinity to death and all things metaphysical. Death would then be the ultimate material loss. Amongst other things, the study of metaphysics can be a very differentiated way of dealing with this loss, which inevitably comes to us all. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 18;

UPDATE celestial
   SET name = 'ninth_house',
       description = '9th House - Philosophies and Far Countries 
The ninth house describes our spiritual leaning, life philosophy and our world view. In fact, these are often influenced by journeys to foreign countries. The attitudes cultivated and formed in this house can greatly influence matters of the 10th. (see below)',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 19;

UPDATE celestial
   SET name = 'tenth_house',
       description = '10th House (MC) - Occupation and Calling 
This house is of particular importance, since it affects not only our choice of profession and our sense of calling - it also has a bearing on our general development, what we become. This continues throughout our lives. According to tradition, as well as more recent experience, this house describes the mother image and the relationship to the real mother.',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 20;

UPDATE celestial
   SET name = 'eleventh_house',
       description = '11th House - Friends and Acquaintances 
The eleventh house describes how we relate to friends, benefactors and teachers - people who wish us well or from whom we can learn. It also shows us in these roles. This house shows how we relate to the society in which we live. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 21;

UPDATE celestial
   SET name = 'twelfth_house',
       description = '12th House - Beyond the Personal 
This house represents those spheres of life in which the individual no longer plays a part, where we step back for a greater whole or lose ourselves in one. Traditional astrology sees hospitals, prisons and psychiatric institutions in this house. It is also associated with monasteries and any other retreats. ',
       update_time = TIMESTAMP '2014-10-05 03:01:57.244'
WHERE id = 22;
