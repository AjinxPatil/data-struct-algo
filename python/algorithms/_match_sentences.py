#!/usr/bin/python

def match_sentences(s1, s2, syndict):
    words1 = s1.split()
    words2 = s2.split()
    if len(words1) != len(words2):
        return False
    for i in range(len(words1)):
        word1 = words1[i]
        word2 = words2[i]
        if word1 in syndict and word2 not in syndict[word1]:
            return False
        i += 1
    return True


def register_synonyms(syndict, w1, w2):
    if w1 is None or w2 is None or syndict is None:
        return False
    if w1 not in syndict and w2 in syndict:
        add_synonym(syndict, w1, w2)
    elif w2 not in syndict and w1 in syndict:
        add_synonym(syndict, w2, w1)
    else:
        syndict[w1] = set([w1, w2])
        syndict[w2] = syndict[w1]


def add_synonym(syndict, w1, w2):
    syndict[w2].add(w1)
    syndict[w1] = syndict[w2]

if __name__ == '__main__':
    syndict = {}
    register_synonyms(syndict, 'rate', 'ratings')
    register_synonyms(syndict, 'approval', 'popularity')
    register_synonyms(syndict, 'rate', 'score')
    s1 = 'Obama popularity rate'
    s2 = 'Obama approval rate'
    s3 = 'Obama popularity ratings'
    s4 = 'Obama approval score'
    s5 = 'popularity ratings Obama'
    print s1, "|", s2, "=", match_sentences(s1, s2, syndict)
    print s3, "|", s4, "=", match_sentences(s3, s4, syndict)
    print s4, "|", s5, "=", match_sentences(s4, s5, syndict)


