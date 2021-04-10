from collections import Counter
from typing import List


class TopVotedCandidate:

    def __init__(self, persons: List[int], times: List[int]):
        self.times = times
        self.persons = persons


    def q(self, t: int) -> int:
        votes = {time:person for time, person in zip(self.times, self.persons) if time <= t}

        count_per_person = dict(Counter(votes.values()))

        winners, highest = [], -1

        for person, count in count_per_person.items():
            if count > highest:
                highest = count
                winners = [person]
            if count == highest:
                winners.append(person)


        winner = winners[0]

        for time, person in votes.items():
            if person in winners:
                winner = person


        return winner












# Your TopVotedCandidate object will be instantiated and called as such:
# obj = TopVotedCandidate(persons, times)
# param_1 = obj.q(t)
