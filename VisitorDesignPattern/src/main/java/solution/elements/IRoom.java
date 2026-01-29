package solution.elements;

import solution.visitors.IRoomVisitor;

// Element interface - represents rooms(elements) that can be visited
public interface IRoom {
    void accept(IRoomVisitor visitor);
}
